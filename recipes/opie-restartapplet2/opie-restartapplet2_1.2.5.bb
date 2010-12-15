require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_applets_restartapplet2.tar.bz2;name=split_core_applets_restartapplet2 \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_applets_restartapplet2.md5sum] = "d5fedf3676bc08e865cc12750c11467a"
SRC_URI[split_core_applets_restartapplet2.sha256sum] = "85a622e7ad4767b065f6ea3464af7d9f839f440bc8fa6bbeab6571a7ab66623f"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
