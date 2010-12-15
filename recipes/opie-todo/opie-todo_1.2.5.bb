require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_pim_todo.tar.bz2;name=split_core_pim_todo \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps \
           file://unbreak-logging.patch"
SRC_URI[split_core_pim_todo.md5sum] = "abbb87630f731ed21882c5eba1ae62e8"
SRC_URI[split_core_pim_todo.sha256sum] = "78efadc5959f3307a75259bf8901d3a582d0105839abb84e537ecfc39039e400"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
