DESCRIPTION = "The Enlightenment C-like scripting language for Edje"
LICENSE = "MIT BSD"
PV = "0.9.9.043+svnr${SRCREV}"
PR = "r2"

inherit efl

# HACK alert: When compiling for VFP embryo emits bugs -- maybe gcc bug
#FULL_OPTIMIZATION_arm =+ "-O0"
