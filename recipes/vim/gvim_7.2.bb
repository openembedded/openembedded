VIMGUI = "gtk2"
VIMX = "--with-x"

require vim_${PV}.bb

DEPENDS += "gtk+ xt"

PR = "${INC_PR}.0"

EXTRA_OECONF += "--enable-gtk2-test"

#might needs RREPLACES as well
RCONFLICTS_${PN} = "vim vim-tiny"
