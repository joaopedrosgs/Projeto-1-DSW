package org.dsw.control;


import at.favre.lib.crypto.bcrypt.BCrypt;

public class Senha {
    private final int hashCost = 10;
    private final BCrypt.Hasher bCrypt = BCrypt.with(BCrypt.Version.VERSION_2Y);

    private String hash;

    public Senha(String plain) {
        this.hash = this.bCrypt.hashToString(this.hashCost, plain.toCharArray());
    }

    public String getHash() {
        return this.hash;
    }

    public boolean compare(String cmpHash) {
        return BCrypt.verifyer().verify(cmpHash.toCharArray(), this.hash.toCharArray()).verified;
    }
}
