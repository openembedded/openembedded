VIMVER = "72"

# vim-tiny sets that too
VIMFEATURES ?= "big"

# GUI type - gvim recipe sets "gtk2"
VIMGUI ?= "none"

# gvim recipes uses "--with-x"
VIMX ?= "--without-x"

require vim.inc

PR = "${INC_PR}.0"

# 001-394.diff contains 394 patches fetched from upstream
SRC_URI += "file://001-394.diff"

# we need to apply patches in other dir then ${S}
do_applypatch() {
	cd ${WORKDIR}/vim${VIMVER}
	patch -p1 <${WORKDIR}/001-394.diff
}

addtask applypatch after do_unpack before do_patch

RCONFLICTS_${PN} = "gvim vim-tiny"
