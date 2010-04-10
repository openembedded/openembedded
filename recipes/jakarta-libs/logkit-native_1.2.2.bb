require logkit_${PV}.bb

inherit java-native

DEPENDS = "fastjar-native oro-native servlet2.3-native gnumail-native gnujaf-native log4j1.2-native avalon-framework-api-native"


SRC_URI[md5sum] = "996ee20d6b5785ab71f4692f64d10f9c"
SRC_URI[sha256sum] = "2c81edc87571fbd05797da7f65515e089c62cbb735bdbd10f93e29bd3aa3ddb8"
