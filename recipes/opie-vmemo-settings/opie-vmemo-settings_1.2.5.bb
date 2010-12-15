require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_settings_sound.tar.bz2;name=split_noncore_settings_sound \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_noncore_settings_sound.md5sum] = "e69c67a0306f0d26cd7c8784ce6a492b"
SRC_URI[split_noncore_settings_sound.sha256sum] = "397769072bd6c20f3493fd98e1b862bf2af33ff93d6dc0c6b6e9f9864b4bd6e4"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
