# we don't want to modify subdir .pro's
!contains( TEMPLATE, subdirs ) {
# if it's already a lib, we ignore it
!contains( TEMPLATE, lib ) {

  contains( CONFIG, quick-app ) {
    message ( Building a quicklaunch application )
    TEMPLATE = lib
    CONFIG += plugin
    DEFINES += OPIE_APP_INTERFACE
  }

  !contains ( CONFIG, quick-app ) {
    message( Building a standalone application )
    TEMPLATE = app
    DEFINES -= OPIE_APP_INTERFACE
  }
}
}

DEFINES += OPIE_NEW_MALLOC 
DEFINES += OPIE_NO_ERASE_RECT_HACKFIX
