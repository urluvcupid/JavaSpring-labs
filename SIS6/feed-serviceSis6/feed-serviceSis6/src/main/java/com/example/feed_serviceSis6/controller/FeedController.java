package com.example.feed_serviceSis6.controller;

import com.example.feed_serviceSis6.dto.ErrorResponse;
import com.example.feed_serviceSis6.dto.FeedItemResponse;
import com.example.feed_serviceSis6.service.FeedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feed")
@Tag(name = "Feed API", description = "Endpoints for reading the user's feed")
public class FeedController {

    private final FeedService feedService;

    public FeedController(FeedService feedService) {
        this.feedService = feedService;
    }

    @Operation(summary = "Get feed by userId", description = "Returns all feed items for the given user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Feed loaded successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping
    public ResponseEntity<List<FeedItemResponse>> getFeed(
            @Parameter(description = "User id to load the feed for", example = "u1")
            @RequestParam String userId
    ) {
        return ResponseEntity.ok(feedService.getFeedByUserId(userId));
    }
}