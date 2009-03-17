# we don't want to modify subdir .pro's
!contains( TEMPLATE, subdirs ) {
# if it's already a lib, we ignore it
!contains( TEMPLATE, lib ) {

  contains( CONFIG, quick-app ) {
    message ( Building a quicklaunch application )
    TEMPLATE = lib
    CONFIG += plugin
    DEFINES += OPIE_APP_INTERFACE
    DEFINES += QUICKAPP_NAME="\"$${TARGET}\""

    system ( touch visibility_qmake_test.c )
    # Test if the compiler supports visibility
    system ( $$(CC) -fvisibility=hidden -c -o visibility_qmake_test.o visibility_qmake_test.c ) {
        message ( "Your compiler does support visibility, we will use it" )
        DEFINES += GCC_SUPPORTS_VISIBILITY
        QMAKE_CFLAGS   += -fvisibility=hidden -fvisibility-inlines-hidden
        QMAKE_CXXFLAGS += -fvisibility=hidden -fvisibility-inlines-hidden
	system ( rm visibility_qmake_test.o )
    }
    system ( rm visibility_qmake_test.c )

  }

  !contains ( CONFIG, quick-app ) {
    message( Building a standalone application )
    TEMPLATE = app
    DEFINES -= OPIE_APP_INTERFACE
    DEFINES += QUICKAPP_NAME="\"$${TARGET}\""
  }
}
}

DEFINES += OPIE_NEW_MALLOC 
DEFINES += OPIE_NO_ERASE_RECT_HACKFIX
