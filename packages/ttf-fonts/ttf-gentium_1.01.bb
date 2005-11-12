DESCRIPTION = "Gentium fonts - TTF Version"
LICENSE = "Gentium"
HOMEPAGE = "http://scripts.sil.org/gentium"
PR = "r0"

SRC_URI = "${DEBIAN_MIRROR}/non-free/t/ttf-gentium/ttf-gentium_${PV}.orig.tar.gz"

include ttf.inc

PACKAGES += "ttf-gentium-alt"

FILES_ttf-gentium-alt = "${datadir}/fonts/truetype/GenAI*.ttf ${datadir}/fonts/truetype/GenAR*.ttf"
FILES_${PN} = "${datadir}/fonts/truetype/GenI*.ttf ${datadir}/fonts/truetype/GenR*.ttf"

#
# LICENSE:
#
# This font is the property of SIL International. It is distributed as
# copyrighted freeware. You may use this software without any charge and may
# distribute it, as is, to others. Commercial distribution of this software is
# restricted without prior written permission. If you wish to distribute this
# software commercially, contact SIL for details on obtaining a license.  You
# may not rent or lease the software, nor may you modify, adapt, translate,
# reverse engineer, decompile, or disassemble the software. You may not make
# derivative fonts from this software. THE SOFTWARE AND RELATED FILES ARE
# PROVIDED "AS IS" AND WITHOUT WARRANTY OF ANY KIND.
#
