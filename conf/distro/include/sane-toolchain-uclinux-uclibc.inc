# Originally brought to you by the Angstrom Distribution

# uclibc:

USE_NLS ?= "no"
USE_NLS_glib-2.0 = "yes"
USE_NLS_glib-2.0-native = "yes"
USE_NLS_gcc-cross = "no"

#mess with compiler flags to use -Os instead of -O2
#Please see http://free-electrons.com/doc/embedded_linux_optimizations/img47.html for some more info
FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -Os -pipe"
BUILD_OPTIMIZATION = "-Os"

#Gcc will die with 'internal consistency error when using the above optimizations
FULL_OPTIMIZATION_avr32 = ""
BUILD_OPTIMIZATION_avr32 = ""

CXXFLAGS += "-fvisibility-inlines-hidden"

