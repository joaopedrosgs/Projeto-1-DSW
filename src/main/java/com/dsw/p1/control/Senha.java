package com.dsw.p1.control;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class Senha {

    private final int hashCost = 10;
    private final BCrypt.Hasher bCrypt = BCrypt.with(BCrypt.Version.VERSION_2Y);

    private String plain;

    public Senha(String plain) {
        this.plain = plain;
    }

    public String getHash() {
        return this.bCrypt.hashToString(this.hashCost, this.plain.toCharArray());
    }

    public boolean compare(String cmpHash) {
        return BCrypt.verifyer().verify(this.plain.toCharArray(), cmpHash.toCharArray()).verified;
    }
}
