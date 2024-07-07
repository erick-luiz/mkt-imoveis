package test

final class TestValidator {

    static <T> T propiedadesNaoSaoNulas(T objeto, Set<String> props) {
        if(props && objeto) {
            props.each { k -> if(objeto[k] == null) {
                    return false
                }
            }
        }
        return true
    }
}
