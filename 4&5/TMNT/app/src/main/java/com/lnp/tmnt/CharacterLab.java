package com.lnp.tmnt;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CharacterLab {
    private static CharacterLab characterlab;
    private List<com.lnp.tmnt.Character> characterList;

    private CharacterLab() {
        characterList = new ArrayList<>();
        UUID uid1 = UUID.randomUUID();
        com.lnp.tmnt.Character ch1 = new com.lnp.tmnt.Character(uid1, R.drawable.tmntleo, "Leonardo", "Leo", R.drawable.ic_charac, "节目1");
        UUID uid2 = UUID.randomUUID();
        com.lnp.tmnt.Character ch2 = new com.lnp.tmnt.Character(uid2, R.drawable.tmntdon, "Donatello", "Don", R.drawable.ic_charac, "节目2");
        UUID uid3 = UUID.randomUUID();
        com.lnp.tmnt.Character ch3 = new com.lnp.tmnt.Character(uid3, R.drawable.tmntraph, "Raphael", "Raph", R.drawable.ic_charac, "节目3");
        UUID uid4 = UUID.randomUUID();
        com.lnp.tmnt.Character ch4 = new com.lnp.tmnt.Character(uid4, R.drawable.tmntmike, "Michelangelo", "Mike", R.drawable.ic_charac, "节目4");
        UUID uid5 = UUID.randomUUID();
        com.lnp.tmnt.Character ch5 = new com.lnp.tmnt.Character(uid5, R.drawable.orga, "奥尔加·伊兹卡", "Orga", R.drawable.ic_charac, "希望之花", R.raw.bk);
        characterList.add(ch1);
        characterList.add(ch2);
        characterList.add(ch3);
        characterList.add(ch4);
        characterList.add(ch5);
    }

    public static CharacterLab get() {
        if (characterlab == null) {
            characterlab = new CharacterLab();
        }
        return characterlab;
    }

    public void addCharacter(com.lnp.tmnt.Character ch) {
        characterList.add(ch);
    }

    public List<com.lnp.tmnt.Character> getCharacterList() {
        return characterList;
    }

    public Character getCharacter(UUID id) {
        for (com.lnp.tmnt.Character ch : characterList) {
            if (ch.getmId().equals(id)) {
                return ch;
            }
        }
        return null;
    }
}
