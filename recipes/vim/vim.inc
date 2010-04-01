DESCRIPTION = "Vi IMproved - enhanced vi editor"
SECTION = "console/utils"
DEPENDS = "ncurses"
# vimdiff doesn't like busybox diff
RSUGGESTS_${PN} = "diffutils"
LICENSE = "vim"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/vim-${PV}"

INC_PR = "r5"

SRC_URI = "ftp://ftp.vim.org/pub/vim/unix/vim-${PV}.tar.bz2;name=vim${PV}tarbz2 \
           ftp://ftp.vim.org/pub/vim/extra/vim-${PV}-extra.tar.gz;name=vim${PV}extratargz \
           ftp://ftp.vim.org/pub/vim/extra/vim-${PV}-lang.tar.gz;name=vim${PV}langtargz "

S = "${WORKDIR}/vim${VIMVER}/src"

inherit autotools update-alternatives

# vim configure.in contains functions which got 'dropped' by autotools.bbclass
do_configure () {
       rm -f auto/*
       touch auto/config.mk
       aclocal
       autoconf
       oe_runconf
       touch auto/configure
       touch auto/config.mk auto/config.h
}



VIMFEATURES ?= "big"
VIMX ?= "--without-x"
VIMGUI ?= "none"

EXTRA_OECONF = "--enable-gui=${VIMGUI} --disable-gtktest \
		--disable-xim --with-features=${VIMFEATURES} \
		--disable-gpm ${VIMX} --disable-netbeans \
		ac_cv_small_wchar_t="no" \
		vim_cv_getcwd_broken=no \
		vim_cv_memmove_handles_overlap=yes \
		vim_cv_stat_ignores_slash=no \
		vim_cv_terminfo=yes \
		vim_cv_tgent=non-zero \
		vim_cv_toupper_broken=no \
		vim_cv_tty_group=world \
		--with-tlib=ncurses"

PACKAGES =+ "vim-common vim-syntax vim-help vim-tutor"
FILES_vim-syntax = "${datadir}/vim/vim${VIMVER}/syntax"
FILES_vim-help = "${datadir}/vim/vim${VIMVER}/doc"
FILES_vim-tutor = "${datadir}/vim/vim${VIMVER}/tutor ${bindir}/vimtutor"

ALTERNATIVE_NAME = "vi"
ALTERNATIVE_PATH = "${bindir}/vim"
ALTERNATIVE_LINK = "${base_bindir}/vi"
ALTERNATIVE_PRIORITY = "100"

SRC_URI[vim7.2tarbz2.md5sum] = "f0901284b338e448bfd79ccca0041254"
SRC_URI[vim7.2tarbz2.sha256sum] = "914db0f2205ebd6f02878295ec2506036ea7500399db112c61a01491cd9a1d86"
SRC_URI[vim7.2langtargz.md5sum] = "d8884786979e0e520c112faf2e176f05"
SRC_URI[vim7.2langtargz.sha256sum] = "11607f539a4518b550bf1606b7d3a6f36c1ffdf566c058e7d94bced78034cd5b"
SRC_URI[vim7.2extratargz.md5sum] = "35e04482f07c57221c9a751aaa3b8dac"
SRC_URI[vim7.2extratargz.sha256sum] = "20894ac79672160bfc4f1d2f9f9775b34d944762d655307a91ca96d358faa04d"

PARALLEL_MAKE = ""
