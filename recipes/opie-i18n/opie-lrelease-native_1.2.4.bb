require ${PN}.inc
PR = "${INC_PR}.1"

TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"
SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_development_translation_opie-lrelease.tar.bz2;name=split_development_translation_opie-lrelease \
           http://sources.openembedded.org/opie-1.2.4-split_development_translation_shared.tar.bz2;name=split_development_translation_shared"
SRC_URI[split_development_translation_opie-lrelease.md5sum] = "16551ffdf59361c330108bf0a0c6960e"
SRC_URI[split_development_translation_opie-lrelease.sha256sum] = "5779e0632e3788be5ddd2d99317e6197f93fa124352551246b21de81f7503ad6"
SRC_URI[split_development_translation_shared.md5sum] = "a55c0f45841e8bc228c7f58097477b46"
SRC_URI[split_development_translation_shared.sha256sum] = "5c129d8c377801cfabfa4dd1969339db570acba9b0a9bef62b3223a438679f78"
