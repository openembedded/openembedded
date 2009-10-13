DESCRIPTION = "Implementation of the JAXB API"
LICENSE = "AL2.0"

AUTHOR = "Apache Software Foundation"
HOMEPAGE = "http://ws.apache.org/jaxme"

SRC_URI = "\
	http://apache.org/dist/ws/jaxme/source/ws-${P}-src.tar.gz \
	http://ftp.hosting-studio.de/pub/linux/apache/ant/source/apache-ant-1.7.1-src.tar.bz2 \
	"

S = "${WORKDIR}/ws-${P}"

inherit java-library

DEPENDS = "fastjar-native log4j1.2 xerces-j xalan-j commons-codec hsqldb antlr antlr-native"

do_compile() {
	oe_makeclasspath cp -s log4j-1.2 xercesImpl xalan2 commons-codec hsqldb antlr
  cp=build-api:build-jaxme:build-js:build-xs:build-pm:$cp


	jaxme_build src/api build-api $cp jaxmeapi-${PV}.jar

	runantlr -o src/js/org/apache/ws/jaxme/js/jparser src/js/org/apache/ws/jaxme/js/jparser/java15.g
	jaxme_build src/js build-js $cp jaxmejs-${PV}.jar

	jaxme_build src/xs build-xs $cp jaxmexs-${PV}.jar

	jaxme_build src/jaxme build-jaxme $cp ${JARFILENAME}

#	jaxme_build src/pm build-pm $cp jaxmepm-${PV}.jar
}

do_install_append() {
	oe_jarinstall jaxmeapi-${PV}.jar jaxmeapi.jar
	oe_jarinstall jaxmejs-${PV}.jar jaxmejs.jar
	oe_jarinstall jaxmexs-${PV}.jar jaxmexs.jar
	oe_jarinstall jaxmepm-${PV}.jar jaxmepm.jar
}

do_stage_append() {
	oe_jarinstall -s jaxmeapi-${PV}.jar jaxmeapi.jar
	oe_jarinstall -s jaxmejs-${PV}.jar jaxmejs.jar
	oe_jarinstall -s jaxmexs-${PV}.jar jaxmexs.jar
	oe_jarinstall -s jaxmepm-${PV}.jar jaxmepm.jar
}

# Compile helper
# 1 - source dir
# 2 - dest dir
# 3 - classpath
# 4 - jar file name
jaxme_build() {
  mkdir -p $2

	ant_sourcepath=${WORKDIR}/apache-ant-1.7.1/src/main

  echo "javac -sourcepath $ant_sourcepath:$1 -cp $3 -d $2 \`find $1 -name "*.java"\`"
  javac -sourcepath $ant_sourcepath:$1 -cp $3 -d $2 `find $1 -name "*.java" -and -not \( -wholename "*junit*" -or -wholename "*examples*" \) `
  (cd $1 && find . -name "*.properties" -exec cp {} ${S}/$2/{} \;)

	rm -rf $2/org/apache/tools

  fastjar -C $2 -c -f $4 .
}
