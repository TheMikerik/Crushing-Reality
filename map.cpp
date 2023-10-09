#include <SDL.h>
#include <SDL_image.h>

const int SCREEN_WIDTH = 800;
const int SCREEN_HEIGHT = 600;
const int TILE_SIZE = 32; // Size of each tile in pixels

int worldMap[15][22] = {
    // Define your game world matrix here, where each value corresponds to a texture.
    // For example, 0 could represent a floor, 1 could represent a wall, etc.
};

void renderMap(SDL_Renderer* renderer, SDL_Texture** textures) {
    for (int i = 0; i < 15; ++i) {
        for (int j = 0; j < 22; ++j) {
            int textureIndex = worldMap[i][j];
            SDL_Rect srcRect = { textureIndex * TILE_SIZE, 0, TILE_SIZE, TILE_SIZE };
            SDL_Rect destRect = { j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE };
            SDL_RenderCopy(renderer, textures[textureIndex], &srcRect, &destRect);
        }
    }
}

int main(int argc, char* args[]) {
    SDL_Init(SDL_INIT_VIDEO);
    IMG_Init(IMG_INIT_PNG); // Initialize SDL_image for loading textures

    SDL_Window* window = SDL_CreateWindow("Game World Map", SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED, SCREEN_WIDTH, SCREEN_HEIGHT, SDL_WINDOW_SHOWN);
    SDL_Renderer* renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_ACCELERATED);

    // Load your textures here, e.g., using SDL_image
    SDL_Texture* textures[NUMBER_OF_TEXTURES];
    textures[0] = IMG_LoadTexture(renderer, "floor.png");
    textures[1] = IMG_LoadTexture(renderer, "wall.png");
    // Load other textures as needed

    bool quit = false;
    SDL_Event e;

    while (!quit) {
        while (SDL_PollEvent(&e) != 0) {
            if (e.type == SDL_QUIT) {
                quit = true;
            }
        }

        SDL_RenderClear(renderer);

        renderMap(renderer, textures);

        SDL_RenderPresent(renderer);
    }

    // Cleanup and destroy textures, renderer, and window

    IMG_Quit();
    SDL_Quit();

    return 0;
}
