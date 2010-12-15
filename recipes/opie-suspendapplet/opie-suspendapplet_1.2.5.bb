require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_applets_suspendapplet.tar.bz2;name=split_core_applets_suspendapplet \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_applets_suspendapplet.md5sum] = "7f176081678fff567bb4e60363ae8930"
SRC_URI[split_core_applets_suspendapplet.sha256sum] = "57becbd351e51e4cd5f80cc2a3469f3b79353076514eb64a1de36c7df29c3de8"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
