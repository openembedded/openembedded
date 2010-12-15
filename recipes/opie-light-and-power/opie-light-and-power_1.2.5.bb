require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_settings_light-and-power.tar.bz2;name=split_core_settings_light-and-power \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_settings_light-and-power.md5sum] = "015b4d171bf91894d8b1fa6679979eee"
SRC_URI[split_core_settings_light-and-power.sha256sum] = "d493018c5b5db81c29585965371402f2d1def7cd7fdcd0bd7a9ccac6ac68d373"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
