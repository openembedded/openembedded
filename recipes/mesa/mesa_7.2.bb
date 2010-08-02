# This is a dummy package so OE can use the poky mesa files
require mesa-dri_${PV}.bb

# override debug optimization for ARM when compiling in thumb mode
# gcc 4.4+ ICEs with -O1 -fno-omit-frame-pointer

DEBUG_OPTIMIZATION_thumb = "-O1 -g"
