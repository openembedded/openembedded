# xc3sprog build file
LICENSE="GPL"
DESCRIPTION="suite of utilities for programming Xilinx FPGAs, CPLDs, and EEPROMs"
HOMEPAGE="http://sourceforge.net/projects/xc3sprog"

DEPENDS += "libftdi"

SRC_URI = "svn://xc3sprog.svn.sourceforge.net/svnroot/xc3sprog;proto=https;module=trunk" 
SRCREV = ${PV}

S="${WORKDIR}/trunk"
PR = "r0"

inherit cmake

