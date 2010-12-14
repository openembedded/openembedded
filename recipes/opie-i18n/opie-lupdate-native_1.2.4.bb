require ${PN}.inc

PR = "r1"

TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"
SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_development_translation_opie-lupdate.tar.bz2;name=split_development_translation_opie-lupdate \
           http://sources.openembedded.org/opie-1.2.4-split_development_translation_shared.tar.bz2;name=split_development_translation_shared"
SRC_URI[split_development_translation_opie-lupdate.md5sum] = "61eba2c6b35ee9df98a8421c4036fb1c"
SRC_URI[split_development_translation_opie-lupdate.sha256sum] = "2bfb8f25bcab075ef51642612d36ad996cb3befe12456ffb924ce90712a27c91"
SRC_URI[split_development_translation_shared.md5sum] = "a55c0f45841e8bc228c7f58097477b46"
SRC_URI[split_development_translation_shared.sha256sum] = "5c129d8c377801cfabfa4dd1969339db570acba9b0a9bef62b3223a438679f78"

