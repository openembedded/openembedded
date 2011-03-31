VIMVER = "72"

# vim-tiny sets that too
VIMFEATURES ?= "big"

# GUI type - gvim recipe sets "gtk2"
VIMGUI ?= "no"

# gvim recipes uses "--with-x"
VIMX ?= "--without-x"

require vim.inc

PR = "${INC_PR}.3"

# 001-411.diff contains 411 patches fetched from upstream
SRC_URI += "file://001-411.diff;patchdir=.."
SRC_URI += "file://configure.in_remove_CC_quotes.patch;patchdir=.."
SRC_URI += "file://vimrc"

do_install_append() {
    install -m 0644 ${WORKDIR}/vimrc ${D}/${datadir}/vim
}

RCONFLICTS_${PN} = "gvim vim-tiny"
PACKAGES =+ "${PN}-vimrc"

FILES_${PN}-vimrc = "${datadir}/vim/vimrc"

