require ${PN}.inc

PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_development_translation_opie-lupdate.tar.bz2;name=split_development_translation_opie-lupdate \
           http://sources.openembedded.org/opie-1.2.5-split_development_translation_shared.tar.bz2;name=split_development_translation_shared"
SRC_URI[split_development_translation_opie-lupdate.md5sum] = "b1460106c3aa098a0bb4775cc0e12273"
SRC_URI[split_development_translation_opie-lupdate.sha256sum] = "91cbc7eda498dffde3c6b9eaade836750801f429c965d291ce0052e321a63611"
SRC_URI[split_development_translation_shared.md5sum] = "c18142103c03fa4d3df4d5eecf12de33"
SRC_URI[split_development_translation_shared.sha256sum] = "958bf759bf7677b40b67661f02245b644e576700d62c4b5655c1d40f9d735154"
