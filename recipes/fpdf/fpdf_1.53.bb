DESCRIPTION = "Free PDF Creator for PHP"
SECTION = "libs"
DEPENDS = ""
RDEPENDS = "php"
LICENSE = "FREEWARE"
PR = "r0"

SRC_URI = "http://www.fpdf.org/en/download/fpdf153.tgz \
	   "

S = "${WORKDIR}/fpdf153"
do_compile() {
    :
}

do_install() {
    install -d  ${D}/usr \
                ${D}/usr/fpdf \
                ${D}/usr/fpdf/font \
                ${D}/usr/fpdf/font/makefont

    install -m 644 ${S}/fpdf.php              ${D}/usr/fpdf/
    install -m 644 ${S}/fpdf.css              ${D}/usr/fpdf/
    install -m 644 ${S}/font/*.php            ${D}/usr/fpdf/font/
    install -m 644 ${S}/font/makefont/*       ${D}/usr/fpdf/font/makefont/	
}

FILES_${PN} = "${exec_prefix}/fpdf/*.* \
               ${exec_prefix}/fpdf/font/*.* \
              "
FILES_${PN}-dev = "${exec_prefix}/fpdf/font/makefont/*"


SRC_URI[md5sum] = "6106c8d0aba37563b7ca9ccc94bc6c95"
SRC_URI[sha256sum] = "44b7e18ba9ae5667dd64c89f7b04627bda5807a3a90255a125702d63c0c4ee17"
# CHECKSUMS.INI MISMATCH: I've got this instead:
#SRC_URI[md5sum] = "2209595e96639eada95d0f4c20f00a5a"
#SRC_URI[sha256sum] = "6321c4b448459d556d3d88f21d44c9d4ec595cc14dbaf6aa6e33f69bd8e5fa6d"
