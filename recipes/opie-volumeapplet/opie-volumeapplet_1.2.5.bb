require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_applets_volumeapplet.tar.bz2;name=split_core_applets_volumeapplet \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_applets_volumeapplet.md5sum] = "5ebd5673372d2927afbc9ad1d8cf5d48"
SRC_URI[split_core_applets_volumeapplet.sha256sum] = "d80c2f63c21f4766c781e87e76033e984282fd19586b4eae3641b6cff5228716"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
