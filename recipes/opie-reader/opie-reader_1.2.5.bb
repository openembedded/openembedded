require ${PN}.inc

PR = "${INC_PR}.0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_apps_opie-reader.tar.bz2;name=split_noncore_apps_opie-reader \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_noncore_apps_opie-reader.md5sum] = "73659a51c96ce3365c2255685142c6f7"
SRC_URI[split_noncore_apps_opie-reader.sha256sum] = "657c03bc8ccb28c0cc8fbc0c46612cbaddbe47ac9ee2856015c38f9712b3a020"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"

