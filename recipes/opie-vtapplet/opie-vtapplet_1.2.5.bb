require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_applets_vtapplet.tar.bz2;name=split_core_applets_vtapplet \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_applets_vtapplet.md5sum] = "820ea3503e75d0bee83ce7d7b0c5549f"
SRC_URI[split_core_applets_vtapplet.sha256sum] = "4d0cb18cb4386c22d945ae500185705d2e1f576a035ffae2610946e786236f9c"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
