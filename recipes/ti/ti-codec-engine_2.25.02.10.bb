require ti-codec-engine.inc

PV = "2_25_02_10_eng"

SRC_URI[cetarball.md5sum] = "8544484dd526cbd41b4981cab25eeafb"
SRC_URI[cetarball.sha256sum] = "746cc67efa074c0c14bf3934fb9d020a0dac193e4f2f2cf2f8a78f385c02a5ca"

# Engineering build - SRC_URI is not public yet - override link
HTTP_PROXY_IGNORE="www.sanb.design.ti.com"
SRC_URI = "http://www.sanb.design.ti.com/tisb_releases/Codec_Engine/${PV}/exports/codec_engine_${PV},lite.tar.gz;name=cetarball"
