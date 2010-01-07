DEPENDS_prepend = "${@["qt4-x11-free ", ""][(bb.data.getVar('PN', d, 1)[:12] == 'qt4-x11-free')]}"

inherit qmake2

# Qt4 uses atomic instructions not supported in thumb mode
ARM_INSTRUCTION_SET = "arm"
