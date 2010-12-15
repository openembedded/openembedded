require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_applets_multikeyapplet.tar.bz2;name=split_core_applets_multikeyapplet \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_applets_multikeyapplet.md5sum] = "8046e4b864f9a8f5673d387368dd49da"
SRC_URI[split_core_applets_multikeyapplet.sha256sum] = "4a16356f27241c46456453cd46f82487d4974970feb845d8a903b607ec355933"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
