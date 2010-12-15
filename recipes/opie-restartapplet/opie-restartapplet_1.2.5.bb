require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_applets_restartapplet.tar.bz2;name=split_core_applets_restartapplet \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_applets_restartapplet.md5sum] = "2d327d372cf085ccf0f932086ab5df63"
SRC_URI[split_core_applets_restartapplet.sha256sum] = "d15e939a2d28fddbaa939828efeb134d135269316a7c5ceea354fd25e3836995"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
