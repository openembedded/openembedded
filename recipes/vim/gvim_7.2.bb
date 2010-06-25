VIMGUI = "gtk2"
VIMX = "--with-x"

require vim_${PV}.bb

DEPENDS += "gtk+ libxt"

EXTRA_OECONF += "--enable-gtk2-test"

#might needs RREPLACES_${PN} as well
RCONFLICTS_${PN} = "vim vim-tiny"
