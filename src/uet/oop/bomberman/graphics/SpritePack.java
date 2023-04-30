package uet.oop.bomberman.graphics;

public interface SpritePack {
    int DEFAULT_SIZE = 16;
    int SCALED_SIZE = 32;
    
    /*
	|--------------------------------------------------------------------------
	| Board sprites
	|--------------------------------------------------------------------------
	 */
	Sprite grass = new Sprite(6,0);
    Sprite brick = new Sprite(7,0);
    Sprite wall = new Sprite(5,0);
    Sprite portal = new Sprite(4,0);
	
	/*
	|--------------------------------------------------------------------------
	| Bomber Sprites
	|--------------------------------------------------------------------------
	 */
	Sprite player_up = new Sprite(0,0);
	Sprite player_down = new Sprite(2,0);
	Sprite player_left = new Sprite(3,0);
	Sprite player_right = new Sprite(1,0);
	
	Sprite player_up_1 = new Sprite(0,1);
	Sprite player_up_2 = new Sprite(0,2);
	
	Sprite player_down_1 = new Sprite(2,1);
	Sprite player_down_2 = new Sprite(2,2);
	
	Sprite player_left_1 = new Sprite(3,1);
	Sprite player_left_2 = new Sprite(3,2);
	
	Sprite player_right_1 = new Sprite(1,1);
	Sprite player_right_2 = new Sprite(1,2);
	
	Sprite player_dead1 = new Sprite(4,2);
	Sprite player_dead2 = new Sprite(5,2);
	Sprite player_dead3 = new Sprite(6,2);
	
	/*
	|--------------------------------------------------------------------------
	| Character
	|--------------------------------------------------------------------------
	 */
	//BALLOM
	Sprite balloom_left1 = new Sprite(9,0);
	Sprite balloom_left2 = new Sprite(9, 1);
	Sprite balloom_left3 = new Sprite(9, 2);
	
	Sprite balloom_right1 = new Sprite(10, 0);
	Sprite balloom_right2 = new Sprite(10, 1);
	Sprite balloom_right3 = new Sprite(10, 2);
	
	Sprite balloom_dead = new Sprite(9, 3);
	
	//ONEAL
	Sprite oneal_left1 = new Sprite(11, 0);
	Sprite oneal_left2 = new Sprite(11, 1);
	Sprite oneal_left3 = new Sprite(11, 2);
	
	Sprite oneal_right1 = new Sprite(12, 0);
	Sprite oneal_right2 = new Sprite(12, 1);
	Sprite oneal_right3 = new Sprite(12, 2);
	
	Sprite oneal_dead = new Sprite(11, 3);
	
	//Doll
	Sprite doll_left1 = new Sprite(13, 0);
	Sprite doll_left2 = new Sprite(13, 1);
	Sprite doll_left3 = new Sprite(13, 2);
	
	Sprite doll_right1 = new Sprite(14, 0);
	Sprite doll_right2 = new Sprite(14, 1);
	Sprite doll_right3 = new Sprite(14, 6);
	
	Sprite doll_dead = new Sprite(13, 6);
	
	//Minvo
	Sprite minvo_left1 = new Sprite(8, 5);
	Sprite minvo_left2 = new Sprite(8, 6);
	Sprite minvo_left3 = new Sprite(8, 7);
	
	Sprite minvo_right1 = new Sprite(9, 5);
	Sprite minvo_right2 = new Sprite(9, 6);
	Sprite minvo_right3 = new Sprite(9, 7);
	
	Sprite minvo_dead = new Sprite(8, 8);
	
	//Kondoria
	Sprite kondoria_left1 = new Sprite(10, 6);
	Sprite kondoria_left2 = new Sprite(10, 6);
	Sprite kondoria_left3 = new Sprite(10, 6);
	
	Sprite kondoria_right1 = new Sprite(11, 6);
	Sprite kondoria_right2 = new Sprite(11, 6);
	Sprite kondoria_right3 = new Sprite(11, 6);
	
	Sprite kondoria_dead = new Sprite(10, 6);
	
	//ALL
	Sprite mob_dead1 = new Sprite(15, 6);
	Sprite mob_dead2 = new Sprite(15, 6);
	Sprite mob_dead3 = new Sprite(15, 6);
	
	/*
	|--------------------------------------------------------------------------
	| Bomb Sprites
	|--------------------------------------------------------------------------
	 */
	Sprite bomb = new Sprite(0, 3);
	Sprite bomb_1 = new Sprite(1, 3);
	Sprite bomb_2 = new Sprite(2, 3);
	
	/*
	|--------------------------------------------------------------------------
	| FlameSegment Sprites
	|--------------------------------------------------------------------------
	 */
	Sprite bomb_exploded = new Sprite(0, 4);
	Sprite bomb_exploded1 = new Sprite(0, 5);
	Sprite bomb_exploded2 = new Sprite(0, 6);
	
	Sprite explosion_vertical = new Sprite(1, 5);
	Sprite explosion_vertical1 = new Sprite(2, 5);
	Sprite explosion_vertical2 = new Sprite(3, 5);
	
	Sprite explosion_horizontal = new Sprite(1, 7);
	Sprite explosion_horizontal1 = new Sprite(1, 8);
	Sprite explosion_horizontal2 = new Sprite(1, 9);
	
	Sprite explosion_horizontal_left_last = new Sprite(0, 7);
	Sprite explosion_horizontal_left_last1 = new Sprite(0, 8);
	Sprite explosion_horizontal_left_last2 = new Sprite(0, 9);
	
	Sprite explosion_horizontal_right_last = new Sprite(2, 7);
	Sprite explosion_horizontal_right_last1 = new Sprite(2, 8);
	Sprite explosion_horizontal_right_last2 = new Sprite(2, 9);
	
	Sprite explosion_vertical_top_last = new Sprite(1, 4);
	Sprite explosion_vertical_top_last1 = new Sprite(2, 4);
	Sprite explosion_vertical_top_last2 = new Sprite(3, 4);
	
	Sprite explosion_vertical_down_last = new Sprite(1, 6);
	Sprite explosion_vertical_down_last1 = new Sprite(2, 6);
	Sprite explosion_vertical_down_last2 = new Sprite(3, 6);
	
	/*
	|--------------------------------------------------------------------------
	| Brick FlameSegment
	|--------------------------------------------------------------------------
	 */
	Sprite brick_exploded = new Sprite(7, 1);
	Sprite brick_exploded1 = new Sprite(7, 2);
	Sprite brick_exploded2 = new Sprite(7, 3);
	
	/*
	|--------------------------------------------------------------------------
	| Powerups
	|--------------------------------------------------------------------------
	 */
	Sprite powerup_bombs = new Sprite(0, 10);
	Sprite powerup_flames = new Sprite(1, 10);
	Sprite powerup_speed = new Sprite(2, 10);
	Sprite powerup_wallpass = new Sprite(3, 10);
	Sprite powerup_detonator = new Sprite(4, 10);
	Sprite powerup_bombpass = new Sprite(5, 10);
	Sprite powerup_flamepass = new Sprite(6, 10);
	
    Sprite heart = new Sprite(5,1);
    Sprite clock = new Sprite(6, 1);
}