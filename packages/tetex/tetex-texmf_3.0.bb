DESCRIPTION = "teTeX data"
LICENSE = "GPL"
SECTION = "console/utils"
PR = "r0"

SRC_URI = "ftp://dante.ctan.org/tex-archive/systems/unix/teTeX/current/distrib/tetex-texmf-${PV}.tar.gz"
S = "${WORKDIR}"

STUFF = "aliases  ChangeLog  doc      dvips      LICENSE.texmf  makeindex  metapost  omega \
         scripts  texdoctk   bibtex   context    dvipdfm        fonts      ls-R      metafont \
         mft      release-tetex-texmf.txt        tex            web2c "

do_install() {
	install -d ${D}${datadir}/texmf
	for i in ${STUFF}
	do
		cp -pPR $i ${D}${datadir}/texmf
	done
}

ALLOW_EMPTY_${PN} = "1"

RRECOMMENDS_${PN} = " \
            tetex-texmf-common \
            tetex-texmf-bibtex \
            tetex-texmf-context \
            tetex-texmf-texdoc \
            tetex-texmf-dvipdfm \
            tetex-texmf-dvips \
            tetex-texmf-fonts \
            tetex-texmf-makeindex \
            tetex-texmf-metafont \
            tetex-texmf-metapost \
            tetex-texmf-mft \
            tetex-texmf-omega \
            tetex-texmf-scripts \
            tetex-texmf-tex \
            tetex-texmf-texdoctk \
            tetex-texmf-web2c "

PACKAGES = "tetex-texmf \
            tetex-texmf-bibtex \
            tetex-texmf-context \
            tetex-texmf-texdoc \
            tetex-texmf-dvipdfm \
            tetex-texmf-dvips \
            tetex-texmf-fonts \
            tetex-texmf-makeindex \
            tetex-texmf-metafont \
            tetex-texmf-metapost \
            tetex-texmf-mft \
            tetex-texmf-omega \
            tetex-texmf-scripts \
            tetex-texmf-tex \
            tetex-texmf-texdoctk \
            tetex-texmf-web2c \
            tetex-texmf-common"

FILES_${PN} = ""
FILES_tetex-texmf-common = "${datadir}/texmf"
FILES_tetex-texmf-bibtex = "${datadir}/texmf/bibtex"
FILES_tetex-texmf-context = "${datadir}/texmf/context"
FILES_tetex-texmf-texdoc = "${datadir}/texmf/doc"
FILES_tetex-texmf-dvipdfm = "${datadir}/texmf/dvipdfm"
FILES_tetex-texmf-dvips = "${datadir}/texmf/dvips"
FILES_tetex-texmf-fonts = "${datadir}/texmf/fonts"
FILES_tetex-texmf-makeindex = "${datadir}/texmf/makeindex"
FILES_tetex-texmf-metafont = "${datadir}/texmf/metafont"
FILES_tetex-texmf-metapost = "${datadir}/texmf/metapost"
FILES_tetex-texmf-mft = "${datadir}/texmf/mft"
FILES_tetex-texmf-omega = "${datadir}/texmf/omega"
FILES_tetex-texmf-scripts = "${datadir}/texmf/scripts"
FILES_tetex-texmf-tex = "${datadir}/texmf/tex"
FILES_tetex-texmf-texdoctk = "${datadir}/texmf/texdoctk"
FILES_tetex-texmf-web2c = "${datadir}/texmf/web2c"
