require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_applets_brightnessapplet.tar.bz2;name=split_noncore_applets_brightnessapplet \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_noncore_applets_brightnessapplet.md5sum] = "63872b9fad86c21486590b6cb8a73679"
SRC_URI[split_noncore_applets_brightnessapplet.sha256sum] = "15537936796880d35d7b5c0b5d4c8e94ecc6db84a3d2ccff5de8f151b4e2fd2a"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
