VIMVER = "72"

# vim-tiny sets that too
VIMFEATURES ?= "big"

# GUI type - gvim recipe sets "gtk2"
VIMGUI ?= "no"

# gvim recipes uses "--with-x"
VIMX ?= "--without-x"

require vim.inc

PR = "${INC_PR}.2"

# 001-411.diff contains 411 patches fetched from upstream
SRC_URI += "file://001-411.diff;apply=no"
SRC_URI += "file://configure.in_remove_CC_quotes.patch;apply=no"

# we need to apply patches in other dir then ${S}
do_applypatch() {
	cd ${WORKDIR}/vim${VIMVER}
	patch -p1 <${WORKDIR}/001-411.diff
	patch -p1 <${WORKDIR}/configure.in_remove_CC_quotes.patch
}

addtask applypatch after do_unpack before do_patch

RCONFLICTS_${PN} = "gvim vim-tiny"
