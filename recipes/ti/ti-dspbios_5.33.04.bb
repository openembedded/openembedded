require ti-dspbios.inc

SRC_URI[biosbin.md5sum] = "fcffe1618f20024fd6580f47cdc0059b"
SRC_URI[biosbin.sha256sum] = "2c1e7feec569a19d3093b136da6aa03574f94052810fe7a78cc81eb37adda24b"

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "5_33_04"
PR = "r2"

