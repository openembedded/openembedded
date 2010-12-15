require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_applets_lockapplet.tar.bz2;name=split_core_applets_lockapplet \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_core_applets_lockapplet.md5sum] = "39a52aa592bf08bd70fcb548792329f3"
SRC_URI[split_core_applets_lockapplet.sha256sum] = "b8fc738b38fed603cd8873f7f0f4212a94377403c24aa593f663b985b4cf63fb"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
