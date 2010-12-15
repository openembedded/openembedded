require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_settings_doctab.tar.bz2;name=split_noncore_settings_doctab \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_noncore_settings_doctab.md5sum] = "7f4cf7e56fd2c6169b89bf92f04e685c"
SRC_URI[split_noncore_settings_doctab.sha256sum] = "268f0782b662ae6c2df4c473d645fd9c7b3221ae39352e407c77d908592e4157"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
