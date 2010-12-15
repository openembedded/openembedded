require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_settings_networksettings.tar.bz2;name=split_noncore_settings_networksettings \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps \
           http://sources.openembedded.org/opie-1.2.5-split_root.tar.bz2;name=split_root \
          "
SRC_URI[split_noncore_settings_networksettings.md5sum] = "c63c0d9c016eb264d42b952657249197"
SRC_URI[split_noncore_settings_networksettings.sha256sum] = "c4ddc3627f08b823eee89fede5fae23f7cb07bd5afad321880c999a25066dc9c"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
SRC_URI[split_root.md5sum] = "47b2ea2c59ac34b3df21d43c53baaccd"
SRC_URI[split_root.sha256sum] = "0fb78622bb7ab459860aaa65fbea6145c45141195c1981164b40807b884628eb"
