package com.example.sbcqrsexmple.cqs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Component;

@Component
public class Registry {
    private final Map<Class<? extends Command>, CommandProvider<?>> commandProviderMap = new HashMap<>();

    public Registry(ApplicationContext applicationContext) {
        String[] names = applicationContext.getBeanNamesForType(CommandHandler.class);
        for (String name : names) {
            registerCommand(applicationContext, name);
        }
    }

    private void registerCommand(ApplicationContext applicationContext, String name ){
        Class<CommandHandler<?, ?>> handlerClass = (Class<CommandHandler<?, ?>>) applicationContext.getType(name);
        assert handlerClass != null;
        Class<?>[] generics = GenericTypeResolver.resolveTypeArguments(handlerClass, CommandHandler.class);
        assert generics != null;
        Class<? extends Command> commandType = (Class<? extends Command>) generics[1];
        commandProviderMap.put(commandType, new CommandProvider<>(applicationContext, handlerClass));
    }

    @SuppressWarnings("unchecked")
    <R, C extends Command<R>> CommandHandler<R,C> getCmd(Class<C> commandClass) {
        return (CommandHandler<R, C>) commandProviderMap.get(commandClass).get();
    }

}
