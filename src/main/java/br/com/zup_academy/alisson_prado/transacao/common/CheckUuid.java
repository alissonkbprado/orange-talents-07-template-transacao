package br.com.zup_academy.alisson_prado.transacao.common;

import java.util.UUID;

public class CheckUuid {

    public static boolean isUuidValid(String uuid) {
        try {
            return UUID.fromString(uuid).toString().equals(uuid);
        } catch (Exception e){
            return false;
        }
    }

    public static boolean isUuidNotValid(String uuid) {
        try {
            return !UUID.fromString(uuid).toString().equals(uuid);
        } catch (Exception e){
            return true;
        }
    }
}
