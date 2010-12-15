require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_apps_opie-gutenbrowser.tar.bz2;name=split_noncore_apps_opie-gutenbrowser \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps \
	   http://sources.openembedded.org/opie-1.2.5-split_etc.tar.bz2;name=split_etc"
SRC_URI[split_noncore_apps_opie-gutenbrowser.md5sum] = "fc101ab0eee9b410ef06326d18c0c950"
SRC_URI[split_noncore_apps_opie-gutenbrowser.sha256sum] = "156ac50053f92c7d4a07a582da427dc3a266322824ba615936eaf77a46c685b4"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
SRC_URI[split_etc.md5sum] = "74ef523ef12e242155bbb745072434d9"
SRC_URI[split_etc.sha256sum] = "eef55ea2248b4f45f3a07beb6012e431dd71d4eefa134d39cc50b4d194c53087"
