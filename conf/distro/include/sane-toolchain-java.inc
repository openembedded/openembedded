# Set PREFFERED and VERSION stuff for working java-toolchain

PREFERRED_PROVIDER_virtual/java-initial ?= "jamvm-initial"
PREFERRED_PROVIDER_virtual/java-native ?= "jamvm-native"

# target cacao is failing to build
# without this provider we get
# DEBUG: sorted providers for java2-runtime are: [
#        '/OE/dev/recipes/cacao/cacao_0.99.4.bb', 
#        '/OE/dev/recipes/jamvm/jamvm_1.5.3.bb', 
#        '/OE/dev/recipes/openjdk/openjdk-5_6b18-1.8.5.bb']
# with this provider we get
# NOTE: selecting openjdk-6-jre to satisfy runtime java2-runtime due to PREFERRED_PROVIDER_openjdk-6-jre = openjdk-6-jre
# DEBUG: sorted providers for java2-runtime are: [
#        '/OE/dev/recipes/openjdk/openjdk-6_6b18-1.8.5.bb', 
#        '/OE/dev/recipes/cacao/cacao_0.99.4.bb', 
#        '/OE/dev/recipes/jamvm/jamvm_1.5.3.bb']
PREFERRED_PROVIDER_openjdk-6-jre = "openjdk-6-jre"

PREFERRED_VERSION_classpath-native = "0.98"
PREFERRED_VERSION_classpath = "0.98"
