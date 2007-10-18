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

