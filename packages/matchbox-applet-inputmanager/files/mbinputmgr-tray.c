/* 
   mbinputmgr
   An inprogress panel app to manager available software input methods

   Copyright (c) 2003 Matthew Allum

   This program is free software; you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation; either version 2, or (at your option)
   any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.
*/

#include "mbinputmgr.h"

enum {
  BUTTON_ACTIVATE,
  BUTTON_MENU,
};

MBMenu        *PopupMenu    = NULL; 
MBPixbuf      *Pixbuf       = NULL;
MBTrayApp     *app; 
int            IconDim      = 16;
int            IconWidth    = 26;
int            TrayDepth    = 0; 	/* width/height dep on orientation */
int            TrayAppLen   = 0; 	/* len of tar app */
MBInpmgrState *Inpmgr_state = NULL;
Bool           ButtonIsDown = False;
int            ButtonActive;
Atom           AtomIMActivate;

typedef struct ButtonImgs {
  
  MBPixbufImage *active;
  MBPixbufImage *inactive;

} ButtonImgs;

void
paint_callback ( MBTrayApp *app, Drawable drw )
{
  int            x = 0, y = 0, ax, ay;
  MBPixbufImage *img_bg = NULL, *img_icon = NULL, *img_selected = NULL;
  int            r = 0x33, g = 0x33, b = 0x33;
  ButtonImgs    *button;
  int            menu_button_offset = 0;

  /* The window has not yet been resized to a what we want */
  if ( TrayDepth == 0 ) return;

  if (mbinputmgr_method_active(Inpmgr_state))
    {
      r = 0xcc, g = 0xcc, b = 0xcc;
    }

  img_bg = mb_tray_app_get_background (app, Pixbuf);

  if (img_bg == NULL)
    return;

  button = (ButtonImgs*)Inpmgr_state->MethodSelected->data;

  if (ButtonIsDown)
    {
      if (ButtonActive == BUTTON_MENU)
	{
	  menu_button_offset = 2;
	  img_selected = button->inactive;
	}
      else img_selected = button->active;
    }
  else
    {
      img_selected = button->inactive;
    }

  /* XXX abort for now if vertical */
  
  if (mb_tray_app_tray_is_vertical (app))
    {
      MBPixbufImage *img_tmp = NULL;

      if (mb_pixbuf_img_get_width(img_bg) != TrayDepth
	  || mb_pixbuf_img_get_height(img_bg) != TrayAppLen)
	{
	  mb_pixbuf_img_free(Pixbuf, img_bg);
	  return;
	}


      /* GREAT BIG FUCKING HACK - 
           app gets expose on orientation change 
           with mb_tray_app_tray_is_vertical = TRUE,
	   but app->h & app->w not updated via missing configure event.
	   need to figure out a better fix than this !!

	   NOTES:
	   - This expose can be basically ignored. 

      */
      if (mb_pixbuf_img_get_width(img_bg) > mb_pixbuf_img_get_height(img_bg))
	{
	  mb_pixbuf_img_render_to_drawable (Pixbuf, img_bg, drw, 0, 0);
	  mb_pixbuf_img_free(Pixbuf, img_bg);
	  return;
	}

      img_tmp = mb_pixbuf_img_scale (Pixbuf, 
				     img_selected, 
				     IconWidth, TrayDepth );

      img_icon = mb_pixbuf_img_transform (Pixbuf, img_tmp, 
					  MBPIXBUF_TRANS_ROTATE_90);

      mb_pixbuf_img_copy_composite (Pixbuf, img_bg, img_icon, 
				    0, 0, TrayDepth, IconWidth, 0, 0);

      ax = IconWidth+2 ; ay = 1 + menu_button_offset;
      
      for (x=4; x>=0; x--)
	{
	  for (y=0; y < ((x-4)*-2)+1; y++)
	    mb_pixbuf_img_plot_pixel(Pixbuf, img_bg, ay, ax+x+y, 0x33, 0x33, 0x33);
	  ay++;
	}

      mb_pixbuf_img_free(Pixbuf, img_tmp);
    }
  else
    {

      if (mb_pixbuf_img_get_width(img_bg) != TrayAppLen
	  || mb_pixbuf_img_get_height(img_bg) != TrayDepth)
	{
	  /* Dont paint till were sized how we want */
	  mb_pixbuf_img_render_to_drawable (Pixbuf, img_bg, drw, 0, 0);
	  mb_pixbuf_img_free(Pixbuf, img_bg);
	  return;
	}

      img_icon = mb_pixbuf_img_scale (Pixbuf, 
				      img_selected, 
				      IconWidth, TrayDepth );

      mb_pixbuf_img_copy_composite (Pixbuf, img_bg, img_icon, 
				    0, 0, IconWidth, TrayDepth, 0, 0);

      ax = IconWidth+2; ay = 1 + menu_button_offset;
      
      for (x=4; x>=0; x--)
	{
	  for (y=0; y < ((x-4)*-2)+1; y++)
	    mb_pixbuf_img_plot_pixel(Pixbuf, img_bg, ax+x+y, ay, 0x33, 0x33, 0x33);
	  ay++;
	}
    }

  mb_pixbuf_img_render_to_drawable (Pixbuf, img_bg, drw, 0, 0);

  /* Free up images */

  mb_pixbuf_img_free( Pixbuf, img_bg );
  mb_pixbuf_img_free( Pixbuf, img_icon );

}

void
resize_callback ( MBTrayApp *app, int w, int h )
{
  /* Image should be 26/16 + 6 for arrow - should fix to be dynamic */

  IconWidth = 26;
  TrayAppLen = IconWidth + 12;

  if (mb_tray_app_tray_is_vertical (app))
    {
      if (w > 16)
	{
	  IconWidth = (26 * w)/16;
	  TrayAppLen = IconWidth + 12;
	}

      TrayDepth = w;
      mb_tray_app_request_size (app, TrayDepth, TrayAppLen );
    }
  else
    {
      if (h > 16)
	{
	  IconWidth = (26 * h)/16;
	  TrayAppLen = IconWidth + 12;
	}

      TrayDepth = h;
      mb_tray_app_request_size (app, TrayAppLen, TrayDepth );
    }
}

void
button_callback (MBTrayApp *app, int x, int y, Bool is_released )
{
  int abs_x, abs_y;

  if (mb_menu_is_active(PopupMenu))
    {
      ButtonIsDown = True;

      if (is_released) 
	{
	  mb_menu_deactivate(PopupMenu);
	  ButtonIsDown = False;
	}

      ButtonActive = BUTTON_MENU;
      mb_tray_app_repaint (app);
      return;
    }

  if (is_released) 
    {
       ButtonIsDown = False;
      if ( (mb_tray_app_tray_is_vertical (app) && y > IconWidth)
	   || (!mb_tray_app_tray_is_vertical (app) && x > IconWidth) )
	{
	  mb_tray_app_get_absolute_coords (app, &abs_x, &abs_y);

	  /* aligned top, position down a little */
	  if (abs_y < 8)
	    {
	      int w, h;
	      mb_menu_get_root_menu_size(PopupMenu, &w, &h);
	      abs_y = h + IconDim + 2;
	    }

	  mb_menu_activate(PopupMenu, abs_x, abs_y);
	  ButtonActive = BUTTON_MENU;
	}
      else
	{
	  ButtonActive = BUTTON_ACTIVATE;
	  mbinputmgr_toggle_selected_method (Inpmgr_state);
	}

      mb_tray_app_repaint (app);
    }
  else
    {
      if ( (mb_tray_app_tray_is_vertical (app) && y > IconWidth)
	   || (!mb_tray_app_tray_is_vertical (app) && x > IconWidth) )
	ButtonActive = BUTTON_MENU;
      else
	ButtonActive = BUTTON_ACTIVATE;

      ButtonIsDown = True;
      mb_tray_app_repaint (app);
    }
}

void
xevent_callback (MBTrayApp *app, XEvent *ev)
{
  if (ev->type == ClientMessage)
    {
      XClientMessageEvent *cmev = (XClientMessageEvent *)&ev->xconfigure;

      if (cmev->message_type == AtomIMActivate)
	{
	  /* De Activate */
	  if (cmev->data.l[0] == 0 && mbinputmgr_method_active(Inpmgr_state))
	    mbinputmgr_toggle_selected_method (Inpmgr_state);
	  /* Activate  */
	  else if (cmev->data.l[0] == 1 
		   && !mbinputmgr_method_active(Inpmgr_state))
	    mbinputmgr_toggle_selected_method (Inpmgr_state);
	}
    }

  mb_menu_handle_xevent (PopupMenu, ev);
}

void
menu_item_activated_callback (MBMenuItem *item_active)
{

  mb_menu_deactivate(PopupMenu);

  mbinpmgr_change_selected_method (Inpmgr_state, 
				   (InputMethod*)mb_menu_item_get_user_data(item_active));

  mb_tray_app_repaint (app);
}

void 
load_icon (InputMethod *method)
{
  int         x,y;
  char       *icon_path;
  ButtonImgs *button = NULL;

  button = malloc(sizeof(ButtonImgs));
  memset(button, 0, sizeof(ButtonImgs));

  /* 
     XXX : free existing images 
  */

  icon_path = mb_dot_desktop_icon_get_full_path (NULL, /* util_get_theme?*/
						 16, 
						 method->icon_name);
  if (!icon_path) 
    {
      fprintf(stderr, "mbinputmgr: Could not load %s\n", icon_path);
      exit(1);
    }

  if ((button->inactive = (void *)mb_pixbuf_img_new_from_file(Pixbuf, icon_path)) 
      == NULL)
    {
      fprintf(stderr, "Could not load %s\n", icon_path);
      exit(1);
    }

  button->active 
    = mb_pixbuf_img_clone(Pixbuf,   button->inactive);

  for (x=0; x<mb_pixbuf_img_get_width(button->active); x++)
    for (y=0; y<mb_pixbuf_img_get_height(button->active); y++)
      {
	int aa;
	unsigned char r,g,b,a;

	mb_pixbuf_img_get_pixel(Pixbuf, button->active, x, y, &r, &g, &b, &a);
	
	aa = (int)a;
	aa -=  0x80; if (aa < 0) aa = 0;
	
	mb_pixbuf_img_set_pixel_alpha(  button->active, x, y, aa);
      }

  method->data = (void *)button;

  free(icon_path);
}

int 
main(int argc, char **argv)
{
  int            i;
  MBPixbufImage *app_icon_img  = NULL;

  app = mb_tray_app_new ( "Input Selector",
			  resize_callback,
			  paint_callback,
			  &argc,
			  &argv );  

  Pixbuf = mb_pixbuf_new(mb_tray_app_xdisplay(app), 
			 mb_tray_app_xscreen(app));

  AtomIMActivate = XInternAtom(mb_tray_app_xdisplay(app), 
			       "_MB_INPUT_REQUEST", False);


  PopupMenu = mb_menu_new (mb_tray_app_xdisplay(app),
			   mb_tray_app_xscreen(app));

  /* mb_menu_set_icon_size(PopupMenu, IconDim); - no icons */

  Inpmgr_state = mbinpmgr_init();

  for (i=0; i<Inpmgr_state->NMethods; i++)
    {
      MBMenuItem     *item;
      load_icon(&Inpmgr_state->Methods[i]);

      item = mb_menu_new_item(PopupMenu, 
			      mb_menu_get_root_menu(PopupMenu), 
			      Inpmgr_state->Methods[i].name, 
			      menu_item_activated_callback,
			      (void *)&Inpmgr_state->Methods[i],
			      0 );
    }

  if ((app_icon_img = mb_pixbuf_img_new_from_file(Pixbuf, 
						  DATADIR "/pixmaps/mbinputmgr.png")) != NULL)
    {
      mb_tray_app_set_icon(app, Pixbuf, app_icon_img);
    }
  else fprintf(stderr, "mbinputmgr: failed to load icon '%s'",
	       DATADIR "/pixmaps/mbinputmgr.png");

  /* Make the tray app end up on right of mb panel */
  mb_tray_app_request_offset (app, -1); 

  mb_tray_app_set_xevent_callback (app, xevent_callback );

  mb_tray_app_set_button_callback (app, button_callback );

  /* XXX set up dnotify to reload entrys only on _addition_  */

  XSelectInput(mb_tray_app_xdisplay(app),
	       mb_tray_app_xrootwin(app),
	       SubstructureNotifyMask);


  mb_tray_app_main (app);

  return 0;
}

