require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_applets_rotateapplet.tar.bz2;name=split_core_applets_rotateapplet \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_applets_rotateapplet.md5sum] = "b8efa8491e7d53430328e55ee6fec62d"
SRC_URI[split_core_applets_rotateapplet.sha256sum] = "b8dab51b515f41ad72a935f99f8bb466f4999d27a75c2505e9fde06bbe1d572b"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
