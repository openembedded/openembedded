require ${PN}.inc

PR = "${INC_PR}.0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_development_translation_opie-lrelease.tar.bz2;name=split_development_translation_opie-lrelease \
           http://sources.openembedded.org/opie-1.2.5-split_development_translation_shared.tar.bz2;name=split_development_translation_shared"
SRC_URI[split_development_translation_opie-lrelease.md5sum] = "e35c6b83652e03eeb1a33b6f88e0cbb7"
SRC_URI[split_development_translation_opie-lrelease.sha256sum] = "aa47f392242acebbb1e4d30e97d0637fae6978c697846571544767c769c30772"
SRC_URI[split_development_translation_shared.md5sum] = "c18142103c03fa4d3df4d5eecf12de33"
SRC_URI[split_development_translation_shared.sha256sum] = "958bf759bf7677b40b67661f02245b644e576700d62c4b5655c1d40f9d735154"
