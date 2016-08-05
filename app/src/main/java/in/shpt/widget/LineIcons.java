/*
 * Copyright 2014 Mike Penz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package in.shpt.widget;

import android.content.Context;
import android.graphics.Typeface;

import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class LineIcons implements ITypeface {
    private static final String TTF_FILE = "line-icons-font-v1.0.0.ttf";
    private static Typeface typeface = null;
    private static HashMap<String, Character> mChars;

    @Override
    public IIcon getIcon(String key) {
        return Icon.valueOf(key);
    }

    @Override
    public HashMap<String, Character> getCharacters() {
        if (mChars == null) {
            HashMap<String, Character> aChars = new HashMap<String, Character>();
            for (Icon v : Icon.values()) {
                aChars.put(v.name(), v.character);
            }
            mChars = aChars;
        }
        return mChars;
    }

    @Override
    public String getMappingPrefix() {
        return "lio";
    }

    @Override
    public String getFontName() {
        return "Line icons";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public int getIconCount() {
        return mChars.size();
    }

    @Override
    public Collection<String> getIcons() {
        Collection<String> icons = new LinkedList<String>();
        for (Icon value : Icon.values()) {
            icons.add(value.name());
        }
        return icons;
    }

    @Override
    public String getAuthor() {
        return "Poovarasan Vasudevan";
    }

    @Override
    public String getUrl() {
        return "http://github.com";
    }

    @Override
    public String getDescription() {
        return "Line Icons to enjoy";
    }

    @Override
    public String getLicense() {
        return "MIT";
    }

    @Override
    public String getLicenseUrl() {
        return "http://github.com";
    }

    @Override
    public Typeface getTypeface(Context context) {
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + TTF_FILE);
            } catch (Exception e) {
                return null;
            }
        }
        return typeface;
    }

    public enum Icon implements IIcon {
        lio_wand('\ue600'),
		lio_volume('\ue601'),
		lio_user('\ue602'),
		lio_unlock('\ue603'),
		lio_unlink('\ue604'),
		lio_trash('\ue605'),
		lio_thought('\ue606'),
		lio_target('\ue607'),
		lio_tag('\ue608'),
		lio_tablet('\ue609'),
		lio_star('\ue60a'),
		lio_spray('\ue60b'),
		lio_signal('\ue60c'),
		lio_shopping_cart('\ue60d'),
		lio_shopping_cart_full('\ue60e'),
		lio_settings('\ue60f'),
		lio_search('\ue610'),
		lio_zoom_in('\ue611'),
		lio_zoom_out('\ue612'),
		lio_cut('\ue613'),
		lio_ruler('\ue614'),
		lio_ruler_pencil('\ue615'),
		lio_ruler_alt('\ue616'),
		lio_bookmark('\ue617'),
		lio_bookmark_alt('\ue618'),
		lio_reload('\ue619'),
		lio_plus('\ue61a'),
		lio_pin('\ue61b'),
		lio_pencil('\ue61c'),
		lio_pencil_alt('\ue61d'),
		lio_paint_roller('\ue61e'),
		lio_paint_bucket('\ue61f'),
		lio_na('\ue620'),
		lio_mobile('\ue621'),
		lio_minus('\ue622'),
		lio_medall('\ue623'),
		lio_medall_alt('\ue624'),
		lio_marker('\ue625'),
		lio_marker_alt('\ue626'),
		lio_arrow_up('\ue627'),
		lio_arrow_right('\ue628'),
		lio_arrow_left('\ue629'),
		lio_arrow_down('\ue62a'),
		lio_lock('\ue62b'),
		lio_location_arrow('\ue62c'),
		lio_link('\ue62d'),
		lio_layout('\ue62e'),
		lio_layers('\ue62f'),
		lio_layers_alt('\ue630'),
		lio_key('\ue631'),
		lio_import('\ue632'),
		lio_image('\ue633'),
		lio_heart('\ue634'),
		lio_heart_broken('\ue635'),
		lio_hand_stop('\ue636'),
		lio_hand_open('\ue637'),
		lio_hand_drag('\ue638'),
		lio_folder('\ue639'),
		lio_flag('\ue63a'),
		lio_flag_alt('\ue63b'),
		lio_flag_alt_2('\ue63c'),
		lio_eye('\ue63d'),
		lio_export('\ue63e'),
		lio_exchange_vertical('\ue63f'),
		lio_desktop('\ue640'),
		lio_cup('\ue641'),
		lio_crown('\ue642'),
		lio_comments('\ue643'),
		lio_comment('\ue644'),
		lio_comment_alt('\ue645'),
		lio_close('\ue646'),
		lio_clip('\ue647'),
		lio_angle_up('\ue648'),
		lio_angle_right('\ue649'),
		lio_angle_left('\ue64a'),
		lio_angle_down('\ue64b'),
		lio_check('\ue64c'),
		lio_check_box('\ue64d'),
		lio_camera('\ue64e'),
		lio_announcement('\ue64f'),
		lio_brush('\ue650'),
		lio_briefcase('\ue651'),
		lio_bolt('\ue652'),
		lio_bolt_alt('\ue653'),
		lio_blackboard('\ue654'),
		lio_bag('\ue655'),
		lio_move('\ue656'),
		lio_arrows_vertical('\ue657'),
		lio_arrows_horizontal('\ue658'),
		lio_fullscreen('\ue659'),
		lio_arrow_top_right('\ue65a'),
		lio_arrow_top_left('\ue65b'),
		lio_arrow_circle_up('\ue65c'),
		lio_arrow_circle_right('\ue65d'),
		lio_arrow_circle_left('\ue65e'),
		lio_arrow_circle_down('\ue65f'),
		lio_angle_double_up('\ue660'),
		lio_angle_double_right('\ue661'),
		lio_angle_double_left('\ue662'),
		lio_angle_double_down('\ue663'),
		lio_zip('\ue664'),
		lio_world('\ue665'),
		lio_wheelchair('\ue666'),
		lio_view_list('\ue667'),
		lio_view_list_alt('\ue668'),
		lio_view_grid('\ue669'),
		lio_uppercase('\ue66a'),
		lio_upload('\ue66b'),
		lio_underline('\ue66c'),
		lio_truck('\ue66d'),
		lio_timer('\ue66e'),
		lio_ticket('\ue66f'),
		lio_thumb_up('\ue670'),
		lio_thumb_down('\ue671'),
		lio_text('\ue672'),
		lio_stats_up('\ue673'),
		lio_stats_down('\ue674'),
		lio_split_v('\ue675'),
		lio_split_h('\ue676'),
		lio_smallcap('\ue677'),
		lio_shine('\ue678'),
		lio_shift_right('\ue679'),
		lio_shift_left('\ue67a'),
		lio_shield('\ue67b'),
		lio_notepad('\ue67c'),
		lio_server('\ue67d'),
		lio_quote_right('\ue67e'),
		lio_quote_left('\ue67f'),
		lio_pulse('\ue680'),
		lio_printer('\ue681'),
		lio_power_off('\ue682'),
		lio_plug('\ue683'),
		lio_pie_chart('\ue684'),
		lio_paragraph('\ue685'),
		lio_panel('\ue686'),
		lio_package('\ue687'),
		lio_music('\ue688'),
		lio_music_alt('\ue689'),
		lio_mouse('\ue68a'),
		lio_mouse_alt('\ue68b'),
		lio_money('\ue68c'),
		lio_microphone('\ue68d'),
		lio_menu('\ue68e'),
		lio_menu_alt('\ue68f'),
		lio_map('\ue690'),
		lio_map_alt('\ue691'),
		lio_loop('\ue692'),
		lio_location_pin('\ue693'),
		lio_list('\ue694'),
		lio_light_bulb('\ue695'),
		lio_Italic('\ue696'),
		lio_info('\ue697'),
		lio_infinite('\ue698'),
		lio_id_badge('\ue699'),
		lio_hummer('\ue69a'),
		lio_home('\ue69b'),
		lio_help('\ue69c'),
		lio_headphone('\ue69d'),
		lio_harddrives('\ue69e'),
		lio_harddrive('\ue69f'),
		lio_gift('\ue6a0'),
		lio_game('\ue6a1'),
		lio_filter('\ue6a2'),
		lio_files('\ue6a3'),
		lio_file('\ue6a4'),
		lio_eraser('\ue6a5'),
		lio_envelope('\ue6a6'),
		lio_download('\ue6a7'),
		lio_direction('\ue6a8'),
		lio_direction_alt('\ue6a9'),
		lio_dashboard('\ue6aa'),
		lio_control_stop('\ue6ab'),
		lio_control_shuffle('\ue6ac'),
		lio_control_play('\ue6ad'),
		lio_control_pause('\ue6ae'),
		lio_control_forward('\ue6af'),
		lio_control_backward('\ue6b0'),
		lio_cloud('\ue6b1'),
		lio_cloud_up('\ue6b2'),
		lio_cloud_down('\ue6b3'),
		lio_clipboard('\ue6b4'),
		lio_car('\ue6b5'),
		lio_calendar('\ue6b6'),
		lio_book('\ue6b7'),
		lio_bell('\ue6b8'),
		lio_basketball('\ue6b9'),
		lio_bar_chart('\ue6ba'),
		lio_bar_chart_alt('\ue6bb'),
		lio_back_right('\ue6bc'),
		lio_back_left('\ue6bd'),
		lio_arrows_corner('\ue6be'),
		lio_archive('\ue6bf'),
		lio_anchor('\ue6c0'),
		lio_align_right('\ue6c1'),
		lio_align_left('\ue6c2'),
		lio_align_justify('\ue6c3'),
		lio_align_center('\ue6c4'),
		lio_alert('\ue6c5'),
		lio_alarm_clock('\ue6c6'),
		lio_agenda('\ue6c7'),
		lio_write('\ue6c8'),
		lio_window('\ue6c9'),
		lio_widgetized('\ue6ca'),
		lio_widget('\ue6cb'),
		lio_widget_alt('\ue6cc'),
		lio_wallet('\ue6cd'),
		lio_video_clapper('\ue6ce'),
		lio_video_camera('\ue6cf'),
		lio_vector('\ue6d0'),
		lio_themify_logo('\ue6d1'),
		lio_themify_favicon('\ue6d2'),
		lio_themify_favicon_alt('\ue6d3'),
		lio_support('\ue6d4'),
		lio_stamp('\ue6d5'),
		lio_split_v_alt('\ue6d6'),
		lio_slice('\ue6d7'),
		lio_shortcode('\ue6d8'),
		lio_shift_right_alt('\ue6d9'),
		lio_shift_left_alt('\ue6da'),
		lio_ruler_alt_2('\ue6db'),
		lio_receipt('\ue6dc'),
		lio_pin2('\ue6dd'),
		lio_pin_alt('\ue6de'),
		lio_pencil_alt2('\ue6df'),
		lio_palette('\ue6e0'),
		lio_more('\ue6e1'),
		lio_more_alt('\ue6e2'),
		lio_microphone_alt('\ue6e3'),
		lio_magnet('\ue6e4'),
		lio_line_double('\ue6e5'),
		lio_line_dotted('\ue6e6'),
		lio_line_dashed('\ue6e7'),
		lio_layout_width_full('\ue6e8'),
		lio_layout_width_default('\ue6e9'),
		lio_layout_width_default_alt('\ue6ea'),
		lio_layout_tab('\ue6eb'),
		lio_layout_tab_window('\ue6ec'),
		lio_layout_tab_v('\ue6ed'),
		lio_layout_tab_min('\ue6ee'),
		lio_layout_slider('\ue6ef'),
		lio_layout_slider_alt('\ue6f0'),
		lio_layout_sidebar_right('\ue6f1'),
		lio_layout_sidebar_none('\ue6f2'),
		lio_layout_sidebar_left('\ue6f3'),
		lio_layout_placeholder('\ue6f4'),
		lio_layout_menu('\ue6f5'),
		lio_layout_menu_v('\ue6f6'),
		lio_layout_menu_separated('\ue6f7'),
		lio_layout_menu_full('\ue6f8'),
		lio_layout_media_right_alt('\ue6f9'),
		lio_layout_media_right('\ue6fa'),
		lio_layout_media_overlay('\ue6fb'),
		lio_layout_media_overlay_alt('\ue6fc'),
		lio_layout_media_overlay_alt_2('\ue6fd'),
		lio_layout_media_left_alt('\ue6fe'),
		lio_layout_media_left('\ue6ff'),
		lio_layout_media_center_alt('\ue700'),
		lio_layout_media_center('\ue701'),
		lio_layout_list_thumb('\ue702'),
		lio_layout_list_thumb_alt('\ue703'),
		lio_layout_list_post('\ue704'),
		lio_layout_list_large_image('\ue705'),
		lio_layout_line_solid('\ue706'),
		lio_layout_grid4('\ue707'),
		lio_layout_grid3('\ue708'),
		lio_layout_grid2('\ue709'),
		lio_layout_grid2_thumb('\ue70a'),
		lio_layout_cta_right('\ue70b'),
		lio_layout_cta_left('\ue70c'),
		lio_layout_cta_center('\ue70d'),
		lio_layout_cta_btn_right('\ue70e'),
		lio_layout_cta_btn_left('\ue70f'),
		lio_layout_column4('\ue710'),
		lio_layout_column3('\ue711'),
		lio_layout_column2('\ue712'),
		lio_layout_accordion_separated('\ue713'),
		lio_layout_accordion_merged('\ue714'),
		lio_layout_accordion_list('\ue715'),
		lio_ink_pen('\ue716'),
		lio_info_alt('\ue717'),
		lio_help_alt('\ue718'),
		lio_headphone_alt('\ue719'),
		lio_hand_point_up('\ue71a'),
		lio_hand_point_right('\ue71b'),
		lio_hand_point_left('\ue71c'),
		lio_hand_point_down('\ue71d'),
		lio_gallery('\ue71e'),
		lio_face_smile('\ue71f'),
		lio_face_sad('\ue720'),
		lio_credit_card('\ue721'),
		lio_control_skip_forward('\ue722'),
		lio_control_skip_backward('\ue723'),
		lio_control_record('\ue724'),
		lio_control_eject('\ue725'),
		lio_comments_smiley('\ue726'),
		lio_brush_alt('\ue727'),
		lio_youtube('\ue728'),
		lio_vimeo('\ue729'),
		lio_twitter('\ue72a'),
		lio_time('\ue72b'),
		lio_tumblr('\ue72c'),
		lio_skype('\ue72d'),
		lio_share('\ue72e'),
		lio_share_alt('\ue72f'),
		lio_rocket('\ue730'),
		lio_pinterest('\ue731'),
		lio_new_window('\ue732'),
		lio_microsoft('\ue733'),
		lio_list_ol('\ue734'),
		lio_linkedin('\ue735'),
		lio_layout_sidebar_2('\ue736'),
		lio_layout_grid4_alt('\ue737'),
		lio_layout_grid3_alt('\ue738'),
		lio_layout_grid2_alt('\ue739'),
		lio_layout_column4_alt('\ue73a'),
		lio_layout_column3_alt('\ue73b'),
		lio_layout_column2_alt('\ue73c'),
		lio_instagram('\ue73d'),
		lio_google('\ue73e'),
		lio_github('\ue73f'),
		lio_flickr('\ue740'),
		lio_facebook('\ue741'),
		lio_dropbox('\ue742'),
		lio_dribbble('\ue743'),
		lio_apple('\ue744'),
		lio_android('\ue745'),
		lio_save('\ue746'),
		lio_save_alt('\ue747'),
		lio_yahoo('\ue748'),
		lio_wordpress('\ue749'),
		lio_vimeo_alt('\ue74a'),
		lio_twitter_alt('\ue74b'),
		lio_tumblr_alt('\ue74c'),
		lio_trello('\ue74d'),
		lio_stack_overflow('\ue74e'),
		lio_soundcloud('\ue74f'),
		lio_sharethis('\ue750'),
		lio_sharethis_alt('\ue751'),
		lio_reddit('\ue752'),
		lio_pinterest_alt('\ue753'),
		lio_microsoft_alt('\ue754'),
		lio_linux('\ue755'),
		lio_jsfiddle('\ue756'),
		lio_joomla('\ue757'),
		lio_html5('\ue758'),
		lio_flickr_alt('\ue759'),
		lio_email('\ue75a'),
		lio_drupal('\ue75b'),
		lio_dropbox_alt('\ue75c'),
		lio_css3('\ue75d'),
		lio_rss('\ue75e'),
		lio_rss_alt('\ue75f');

        char character;

        Icon(char character) {
            this.character = character;
        }

        public String getFormattedName() {
            return "{" + name() + "}";
        }

        public char getCharacter() {
            return character;
        }

        public String getName() {
            return name();
        }

        // remember the typeface so we can use it later
        private static ITypeface typeface;

        public ITypeface getTypeface() {
            if (typeface == null) {
                typeface = new LineIcons();
            }
            return typeface;
        }
    }
}
